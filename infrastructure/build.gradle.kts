import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.github.dkurata38.liblio"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

sourceSets {
    main {
        resources {
            srcDir("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.4.3"))
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.1.4")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.mybatis.generator:mybatis-generator-core:1.4.0")
        classpath( "org.postgresql:postgresql:42.2.0")
    }
}

tasks.register("mybatisGenerator") {
    doLast {
        val warnings = mutableListOf<String>()
        val configFile = File("src/main/resources/generatorConfig.xml")
        val parser = org.mybatis.generator.config.xml.ConfigurationParser(warnings)
        val configuration = parser.parseConfiguration(configFile)
        val callback = org.mybatis.generator.internal.DefaultShellCallback(true)
        val generator = org.mybatis.generator.api.MyBatisGenerator(configuration, callback, warnings)
        generator.generate(null)
    }
}
