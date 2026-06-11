# PT-datasoft-backend

Backend REST desarrollado con Spring Boot 3 y Oracle Database para la prueba técnica de DataSoft.

---

## Requisitos previos

- Java 21
- Maven 3.9+
- Docker y Docker Compose

---

## 1. Levantar el contenedor de base de datos

Desde la raíz del proyecto ejecuta:

```bash
docker-compose up -d
```

Esto levanta Oracle Free 23c en el puerto `1521`. La primera vez puede tardar unos minutos mientras Oracle inicializa la base de datos y ejecuta los scripts de `db/init.sql` y `db/seed.sql`.

Para verificar que el contenedor está listo:

```bash
docker logs -f datasoft-db
```

Espera hasta ver el mensaje `DATABASE IS READY TO USE!`.

---

## 2. Correr el proyecto

Acceder a la carpeta main/java y luego saldra el archivo "PruebaTecnicaAplication" dar clic al boton de play y correra el proyecto

La API quedará disponible en `http://localhost:8080`.

---

## 3. Acceder a Swagger

Con la aplicación corriendo, abre el siguiente enlace en el navegador:

```
http://localhost:8080/swagger-ui/index.html
```

Desde ahí puedes explorar y probar todos los endpoints disponibles.

---

## 4. Conectarse a DBeaver

Usa los siguientes datos para conectarte a la base de datos desde DBeaver:

| Campo            | Valor      |
|------------------|------------|
| Host             | localhost  |
| Puerto           | 1521       |
| Service Name     | FREEPDB1   |
| Usuario          | datasoft   |
| Contraseña       | datasoft   |

**Pasos:**

1. Abre DBeaver y crea una nueva conexión de tipo **Oracle**.
2. Selecciona la opción **Service Name** (no SID).
3. Ingresa los datos de la tabla anterior.
4. Haz clic en **Test Connection** para verificar y luego en **Finish**.
