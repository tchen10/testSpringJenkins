# TestSpringSnap

[![Build Status](https://snap-ci.com/snap-ci/docs.snap-ci.com/branch/master/build_image)](https://snap-ci.com/sebradloff/testSpringSnap/branch/master)

## Project Set Up
1. Clone the repository
2. Navigate to your project directory.

    ```
    ./gradlew clean build
    ```

3. Initialize the database.

    ```
    ./gradlew dbInit
    ```

4. Migrate the database.

    ```
    ./gradlew setEnv flywayMigrate
    ```

## Running the App
1. Set your profile to the local profile.

    ```
    export PROFILE=local
    ```

2. Run the application.

    ```
    ./gradlew clean compileJava runApp`
    ```

## Unit Tests
1. From your project directory, run

    ```
    ./gradlew clean build
    ```

## Database
We use flyway for our database migration tool. Flyway comes with a lot of commands out of the box.
- `./gradlew flywayMigrate` : Migrates the database
- `./gradlew flywayClean` : Drops all objects in the configured schemas
- `./graldew flywayInfo` : Prints the details and status information about all the migrations
- `./gradlew flywayValidate` :	Validates the applied migrations against the ones available on the classpath
- `./gradlew flywayBaseline` :	Baselines an existing database, excluding all migrations up to and including baselineVersion
- `./gradlew flywayRepair` :	Repairs the metadata table


## Backup Heroku DB
-To schedule your heroku db backup type this command from your command line assuming your repo is remotely connected to heroku: `heroku pg:backups schedule DATABASE_URL --at '02:00 America/Los_Angeles'`, this schedules a backup every day at 2:00PM PST
-To add a heroku backup to your SNAP-CI script when you deploy the app to Heroku: have `heroku pg:backups capture --app APP_NAME` as a command
