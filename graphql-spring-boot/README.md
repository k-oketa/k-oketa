# graphql-spring-boot

GraphQLの勉強として、[graphql-java-kickstartのsamples/tools-spring-boot](https://github.com/graphql-java-kickstart/samples/tree/master/tools-spring-boot) を写生し、DBへのアクセス機能を制作した。

## 環境

- Java 17 (OpenJDK)
- Maven
- H2DB
- IntelliJ

## 設定

### H2DB

- **Connection Type:** `Embedded`
- **Path:** `~/h2db/graphql_spring_boot;mode=PostgreSQL;AUTO_SERVER=TRUE`
- **User:** `graphql`
- **Password:** `graphql`

### 実行後

http://localhost:9091/graphiql に接続し、Queryを入力。

**Queryの例:**

```graphql
query {
  post(id: "1") {
    id
    text
    comments {
      id
      description
    }
  }
}
```