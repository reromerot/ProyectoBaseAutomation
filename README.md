# 🧪 Proyecto Base de Automatización - Serenity BDD + Gradle + Selenium + Java + Cucumber

Este proyecto es una base sólida para pruebas automatizadas de aplicaciones web utilizando Serenity BDD, Gradle, Selenium WebDriver, Java y Cucumber. Está diseñado para facilitar la escalabilidad, reutilización y configuración dinámica de pruebas.

---

## 🚀 Tecnologías Utilizadas

- **Serenity BDD**: Framework para pruebas automatizadas con informes detallados.
- **Gradle**: Sistema de construcción y gestión de dependencias.
- **Selenium WebDriver**: Automatización de navegadores.
- **Java**: Lenguaje principal del proyecto.
- **Cucumber**: Definición de pruebas en lenguaje natural (Gherkin).

---

## ⚙️ Configuración del Proyecto

### serenity.properties

Este archivo permite configurar parámetros clave del proyecto, como:

```properties
webdriver.driver=chrome
webdriver.base.url=https://miapp.com
webdriver.chrome.driver=src/test/resources/drivers/chromedriver.exe

# URL dinámica para diferentes entornos
env=qa
urls.qa=https://qa.miapp.com
urls.dev=https://dev.miapp.com
urls.prod=https://miapp.com
urls.adminPortal=https://admin.miapp.com
urls.qaPortal=https://qa.miapp.com
```

Puedes acceder a estas propiedades desde el código usando:

```java
EnvironmentSpecificConfiguration.from(environmentVariables)
    .getProperty("webdriver.base.url");
```

---

## 🧭 Estructura del Proyecto

```
src/
├── main/
│   └── java/
├── test/
│   ├── java/
│   │   ├── steps/           # Definición de pasos de Cucumber
│   │   ├── pages/           # Page Objects
│   │   ├── runners/         # Runners de Cucumber
│   │   └── utils/           # Utilidades y helpers
│   └── resources/
│       ├── features/        # Archivos .feature
│       └── drivers/         # WebDrivers
```

---

## 🧪 Agregar Nuevos Escenarios

Para incluir nuevos escenarios:

1. **Crear un archivo `.feature`** en `src/test/resources/features/` con el nuevo escenario.
2. **Definir los pasos** en una clase dentro de `steps/`.
3. **Agregar Page Objects** si se trata de una nueva página.
4. **Actualizar el runner** si es necesario.

Ejemplo de escenario en Gherkin:

```gherkin
Feature: Validación de login

  Scenario: Usuario ingresa credenciales válidas
    Given el usuario está en la página de login de "<pageAlias>"
    When ingresa usuario y contraseña   
    Then accede al panel principal
```

---

## 📦 Ejecución de Pruebas

Para ejecutar los tests:

```bash
./gradlew clean test aggregate
```

Los reportes se generan automáticamente en:

```
target/site/serenity/index.html
```

---

## 📌 Notas

- Puedes cambiar el navegador modificando `webdriver.driver` en `serenity.properties`.
- Las URLs se adaptan dinámicamente según el entorno definido (`env=qa`, `env=dev`, etc.).
- El proyecto está preparado para escalar con múltiples páginas y escenarios.

---

## 🧠 Contribuciones

Si deseas extender el proyecto, puedes agregar nuevos módulos, hooks, o integraciones con herramientas como Jenkins, Docker, o Allure.

---
