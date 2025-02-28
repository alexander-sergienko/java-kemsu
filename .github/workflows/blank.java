name: Java CI with Gradle

on:
  pull_request:
    branches: [ "master" ]
  push:
    branches: [ "master" ]

jobs:
  build-test:
    name: Compile and test application

    runs on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3
      - name: Set up JGK 24
        uses: actions/setup-java@v3
        with:
          java-versions: '21'
          distribution: 'temurin'

      - name: Grand executive permission for gradlew
        run: chmod +x ./gradlew

      - name: Gradlew clean
        run: ./gradlew clean

      - name: Gradlew test run
        id: test
        run: ./gradlew test
