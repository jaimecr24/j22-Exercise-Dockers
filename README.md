<h1 style="color:white">Docker con PostgreSQL</h1>
<h4 style="color:white">Creación de un docker de una base de datos test con postgreSQL accesible con postman a través de otro docker con una aplicación de spring boot</h4>
<hr>
<p>Crear imagen Docker que incluya una aplicación Spring Boot que se conecte a una base de datos PostgreSQL.  

Levantar Docker con servidor de PostgreSQL que no sea accesible desde nuestro Windows, es decir, no mapear el puerto de postgres a nuestro host (“-p 5432:5432”).   El usuario para conectarse será  ‘postgres’ y el password: ‘contrasena’. Se creará la base de datos ‘test’

Deberemos meter en un Docker la aplicación de Spring Boot y el servidor de PostgreSQL deberá estar en otro Docker, dentro de la misma red virtual para que ambos contenedores Docker se vean entre ellos.

Desde Windows deberemos podernos hacer peticiones con postman a la aplicación en Spring Boot. </p>
<h3 style="color:white">Creación del docker con postgreSQL:</h3>
<p style="color:yellow">docker run --network mynetwork --name postgres_test -ePOSTGRES_USER=postgres -e POSTGRES_PASSWORD=contrasena -e POSTGRES_DB=test postgres</p>
<p></p>
<h3 style="color:white">Creación de docker con la aplicación de spring boot:</h3>
<p style="color:yellow">docker build -t spring .</p>
<p>(Se ejecuta en la carpeta raíz de la aplicación, donde está el dockerfile y la carpeta target con el jar)</p>
<p style="color:yellow">docker run --network mynetwork --name spring1 -p8081:8080 spring </p>
<p>(Se pone en marcha en el contenedor spring1, en la misma red donde está el docker de postgresql y se mapea el puerto donde vamos a hacer las peticiones desde postman con el puerto 8080 del docker)</p>
<p></p>
<p>La base de datos test tiene una sola tabla "customers" con 4 campos de tipo string: customerid, firstname, surname, shipping_state.
La tabla tiene 2 registros de ejemplo introducidos desde la consola del docker.</p>
<p style="color:white">Para entrar a la consola y al postgresql:</p>
<p style="color:yellow">docker start postgres_test</p>
<p style="color:yellow">docker exec -ti postgres_test bash</p>
<p>psql -U postgres</p>
<p>\l: listar las bases de datos</p>
<p>\c test: conectar con la base de datos test</p>
<p>\dt: información sobre las tablas</p>
<p>\d customers: información sobre la tabla customers</p>
<p></p>
<p></p>
<p>Opciones en la configuración maven de spring boot: clean install -DskipTests</p>
