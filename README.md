pagarme-java
=========

Pagar.me's Java API

[![Build Status](https://travis-ci.org/adrianoluis/pagarme-java.png?branch=master)](https://travis-ci.org/adrianoluis/pagarme-java)

## Support
If you have any problem or suggestion please open an issue [here](https://github.com/adrianoluis/pagarme-java/issues).

## Usage

Simply put the following snippet into your proper build config:

#### Apache Maven

##### Repository
```
<repositories>
    <repository>
        <id>pagarme-java-mvn-repo</id>
        <url>https://raw.githubusercontent.com/adrianoluis/pagarme-java/mvn-repo/</url>
        <releases>
            <enabled>true</enabled>
            <updatePolicy>never</updatePolicy>
        </releases>
    </repository>
</repositories>
```

##### Dependency
```
<dependency>
    <groupId>me.pagar</groupId>
    <artifactId>pagarme-java</artifactId>
    <version>${version.pagarme}</version>
</dependency>
```

#### Gradle/Grails

##### Repository
```
repositories {
    maven { url 'https://raw.githubusercontent.com/adrianoluis/pagarme-java/mvn-repo' }
}
```

##### Dependency
```
compile 'me.pagar:pagarme-java:1.0.1'
```

#### Apache Buildr

##### Dependency
```
'me.pagar:pagarme-java:jar:1.0.1'
```

#### Apache Ivy

##### Dependency
```
<dependency org="me.pagar" name="pagarme-java" rev="1.0.1">
    <artifact name="pagarme-java" type="jar" />
</dependency>
```

#### Groovy Grape

##### Dependency
```
@Grapes(
  @Grab(group='me.pagar', module='pagarme-java', version='1.0.1')
)
```

#### Scala SBT

##### Dependency
```
libraryDependencies += "me.pagar" % "pagarme-java" % "1.0.1"
```

#### Leiningen

##### Dependency
```
[me.pagar/pagarme-java "1.0.1"]
```

## License

Check [here](LICENSE).