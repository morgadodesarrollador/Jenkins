
#cd AppNodeJS
#npm install
echo "ejecución del contenedor"
docker run -dit --name appnode -p 3000:3000  morgadoberruezo/appnodejs
