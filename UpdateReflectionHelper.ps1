
docker run -it --rm -v "${PWD}:/data" -w /data craftdock/alpine-data sh -c "gh-downloader -u InventivetalentDev -r ReflectionHelper -p src/main/java -b master -o src/main/java"
  
