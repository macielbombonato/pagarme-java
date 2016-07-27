package me.pagar;

import com.google.common.base.CaseFormat;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import me.pagar.util.BulkAnticipationAdapter;
import me.pagar.util.DateTimeAdapter;
import me.pagar.util.JsonUtils;
import me.pagar.util.LocalDateAdapter;
import org.atteo.evo.inflector.English;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.ws.rs.HttpMethod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class PagarMeModel<PK extends Serializable> {

    /**
     * Número identificador da transação
     */
    @Expose(serialize = false)
    @SerializedName("id")
    private PK id;

    /**
     * Data de criação da transação no formato ISODate
     */
    @Expose(serialize = false)
    @SerializedName("date_created")
    private DateTime createdAt;

    private transient String className;

    private transient Collection<String> dirtyProperties;

    protected void validateId() {

        if (getId() == null) {
            throw new IllegalArgumentException("The Object ID must be set in order to use this method.");
        }

    }

    public PagarMeModel() {
        className = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, English.plural(getClass().getSimpleName()));
        dirtyProperties = new ArrayList<String>();
    }

    /**
     * {@link #id}
     */
    public PK getId() {
        return id;
    }

    /**
     * {@link #createdAt}
     */
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public String getClassName() {
        return className;
    }

    public void setId(final PK id) {
        this.id = id;
    }

    public void setClassName(final String className) {
        this.className = className;
    }

    protected JsonObject refreshModel() throws PagarMeException {
        return get(this.id);
    }
    
    protected JsonObject get(final PK id) throws PagarMeException {
        validateId();

        if (null == id) {
            throw new IllegalArgumentException("You must provide an ID to get this object data");
        }

        final PagarMeRequest request = new PagarMeRequest(HttpMethod.GET, String.format("/%s/%s", className, id));

        return request.execute();
    }

    protected JsonArray paginate(final Integer totalPerPage) throws PagarMeException {
        return paginate(totalPerPage, 1);
    }

    protected JsonArray paginate(final Integer totalPerPage, Integer page) throws PagarMeException {
        final Map<String, Object> parameters = new HashMap<String, Object>();

        if (null != totalPerPage && 0 != totalPerPage) {
            parameters.put("count", totalPerPage);
        }

        if (null == page || 0 >= page) {
            page = 1;
        }

        parameters.put("page", page);

        final PagarMeRequest request = new PagarMeRequest(HttpMethod.GET, String.format("/%s", className));
        request.getParameters().putAll(parameters);

        return request.execute();
    }

    protected <T extends PagarMeModel> T save(final Class<T> clazz) throws PagarMeException {

        if (!validate()) {
            return null;
        }

        final PagarMeRequest request = null == id ?
                new PagarMeRequest(HttpMethod.POST, String.format("/%s", className)) :
                new PagarMeRequest(HttpMethod.PUT, String.format("/%s/%s/", className, id));
        request.setParameters(JsonUtils.objectToMap(this));

        final JsonElement element = request.execute();
        flush();

        return JsonUtils.getAsObject((JsonObject) element, clazz);
    }

    protected void addUnsavedProperty(final String name) {
        for (String s : dirtyProperties) {
            if (s.startsWith(name.concat("."))) {
                dirtyProperties.remove(s);
            }
        }
        dirtyProperties.add(name);
    }

    protected void flush() {
        dirtyProperties.clear();
    }

    protected boolean validate() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final PagarMeModel<?> that = (PagarMeModel<?>) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        try {
            return new GsonBuilder()
                    .registerTypeAdapter(DateTime.class, new DateTimeAdapter())
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .registerTypeAdapter(BulkAnticipation.class, new BulkAnticipationAdapter())
                    .create()
                    .toJson(this);
        } catch (UnsupportedOperationException e) {
            return getClass().getSimpleName().concat(String.format("=(%s)", this.id));
        }
    }

}