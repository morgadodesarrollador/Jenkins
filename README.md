## Proyectos o ejemplos
### rama-dslbasicos
- ejemplos básicos de ejecución de script
- primer ejemplo de archivo DSL con extension groovy

### rama-appnodejs
- partimos de una app basada en node y express del típico Hello world
- Tenemos un Dockerfile donde crearemos un contenedor de node y al que le inyectamos el proyecto Hello world
  actualizamos con npm install y lanzamos el contenedor con npm start
- Una carpeta DSL donde tenemos dos dsl jobs 
  1.  nodejsDSL.groovy: DSL Job que instala la app Hello world en el servidor de jenkins
  2.  nodejsDockerDSL.groovy: DSL Job que despliega la app Hello world dentro de un contenedor de node
    