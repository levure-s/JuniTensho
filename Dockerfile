# Maven with Eclipse Temurin JDK 23
FROM maven:3-eclipse-temurin-23

# 作業ディレクトリを設定
WORKDIR /app

# プロジェクトの全ファイルをコンテナにコピー
COPY . .

# 依存関係をインストールしてビルド
RUN mvn clean package -DskipTests

# アプリケーションの JAR ファイルを起動
ENTRYPOINT ["java", "-jar", "target/JuniTensho-0.0.1-SNAPSHOT.jar"]
