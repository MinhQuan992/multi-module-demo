# HOW TO CREATE THIS PROJECT?

## 1. Create a new Maven project with IntelliJ IDEA

- Open IntelliJ IDEA, create a new Maven project. Don't need to choose _Create from archetype_.
- Delete _src_ folder in the project since we don't need to use it.

## 2. Create new modules

- Add this line in file pom.xml of the ROOT project:
  ```xml
  <packaging>pom</packaging>
  ```
- Use this command in terminal to create a new module:
  ```shell
  mvn archetype:generate -DgroupId="<your group id>"  -DartifactId="<your module name>" -DarchetypeArtifactId="maven-archetype-quickstart"
  ```
- Because a project in the service module is a Spring Boot project, we need to define parent for the ROOT project like this:
  ```xml
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.4</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  ```

### 2.1. Service Module

- This is a Spring Boot project. Add necessary dependencies in pom.xml of this module and start writing codes.
- We need to generate a document for these APIs. We use [springdoc-openapi](https://www.baeldung.com/spring-rest-openapi-documentation) to do this.
  ```xml
    <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-ui</artifactId>
      <version>1.5.2</version>
    </dependency>
  ```
  ```xml
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <version>2.5.4</version>
        <executions>
          <execution>
            <id>pre-integration-test</id>
            <goals>
              <goal>start</goal>
            </goals>
          </execution>
          <execution>
            <id>post-integration-test</id>
            <goals>
              <goal>stop</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-maven-plugin</artifactId>
        <version>0.2</version>
        <executions>
          <execution>
            <phase>integration-test</phase>
            <goals>
              <goal>generate</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <apiDocsUrl>http://localhost:8080/v3/api-docs</apiDocsUrl>
          <outputFileName>openapi.json</outputFileName>
          <outputDir>../client</outputDir>
        </configuration>
      </plugin>
  ```
- To generate the document, we use this command in terminal:
  ```shell
  mvn clean verify -DskipTests
  ```
  After running the command above, we will get a document named **openapi.json** in folder ROOT/client.

### 2.2. Java Client (in folder ROOT/client)

- After generating APIs' documents, we generate Java client by using [openapi-generator-cli](https://openapi-generator.tech/docs/usage/#generate) with [configurations](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/java.md) in file **config.yaml**:
  ```shell
  openapi-generator-cli generate -i openapi.json -g java -o source -c config.yaml
  ```
- After generating successfully, we right click on file pom.xml, then choose _Add as Maven Project_.
- In file pom.xml of this client project, we add a relative path to parent pom by using _ralativePath_ tag inside of _parent_ tag:
  ```xml
  <relativePath>../../pom.xml</relativePath>
  ```
- Then, we can generate jar files for this project by using this command in terminal:
  ```shell
  mvn clean install
  ```
- In file pom.xml of the ROOT project, we add client module:
  ```xml
  <module>client/source</module>
  ```

### 2.3. Sample Module

- In the project of this module, to be able to use Java client, we need to add Java client as a dependency in file pom.xml:
  ```xml
    <dependency>
      <groupId>org.example</groupId>
      <artifactId>openapi-java-client</artifactId>
      <version>v0</version>
    </dependency>
  ```
- Then, we can import Java client module in App.java to use.
- **IMPORTANT NOTE**: Remember to run the service module before running App.java.