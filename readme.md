# Keycloak Custom Rest API
## Installation
 1. Run  `mvn clean install` command from CLI. This will generate a `target` folder. Under the `target` folder there will be `{project artifact id}-*.jar` file.
 2.  Copy that `jar` file to the Keycloak `standalone/deployments/` directory. For an example, If you run your Keycloak in docker container, you can use the following command:
 ```dillinger
docker cp <jar_file_path> keycloak:/opt/jboss/keycloak/standalone/deployments/
```
## Demo
**Request:**
```sh
curl --location --request GET 'http://localhost:8833/auth/realms/demo/customApi/users/searchUserByAttribute?attr=entity_id&value=1'
```
**Response:**
```json
[
    {
        "userName": "Santosh",
        "firstName": "Santosh",
        "id": "ajsde97-ecac-4e3f-b45b-8dhdud",
        "email": "santosh@gamil.com",
        "entity_id": "19"
    }
]
```
