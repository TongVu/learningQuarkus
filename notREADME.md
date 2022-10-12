
```
# To build file jar with maven
$ mvn package -DskipTests

# To build native jar file
 PS: to run the command below, you have to install
 Visual Studio 2017 Visual C++ Build Tools
 after installation completed, open 
 x64 Native Tools Command Prompt to navigate to
 directory of the project then run the command:
$ mvn package "-Dquarkus.package.type=native"

# To build with other profile
$ mvn package "-Dquarkus.profile=dev"

# Navigate to target, then navigate to quarkus-app
$ cd target/quarkus-app

# run jar file
$ java -jar quarkus-run.jar

# To execute the native test
$ mvn verify -Pnative

# add docker extension
$ mvn quarkus:add-extension -Dextension="container-image-docker"

# Create a container
# Ps: the docker image name will be : <id>/<artifact id> in the pom file

# build with normal jar
$ mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=jar -Dquarkus.container-image.tag=jvm

# build with legacy jar
$ mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=legacy-jar -Dquarkus.container-image.tag=jvm

# Docker run
$ docker run -i --rm -p 8080:8080 tphvu/rest-book:jvm

#build with native jar
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.tag=native

# Docker run native
docker run -i --rm -p 8080:8080 -d tphvu/rest-book:native

# Create a whole quarkus project:
mvn -U io.quarkus-maven-plugin:create -DprojectGroupId=com.axonactive.com -DprojectArtifactId=<name-of-the-project> -Dextension="resteasy-jsonb-container-image-docker"
```
