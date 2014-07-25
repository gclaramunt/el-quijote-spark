// carga el archivo / loads the file
val texto=sc.textFile("el-quijote.txt")

//cantidad de lineas / line count
texto.count

//primera linea / first line
texto.first

//cantidad de lineas con "Quijote" / count of lines containing "Quijote"
texto.filter(line => line.contains("Quijote")).count

//cuantas palabras tiene la linea con mas palabras / how many words has the line with most words
texto.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)

//la linea con mas palabaras / get the line with most words 
texto.map(line => (line,line.split(" ").size)).reduce((a, b) => if (a._2 > b._2) a else b)._1

//el hello world de big data: conteo de palabras / big data's "hello world": word count  
val wordCounts = texto.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_+_)

//array con las primeras 100 entradas / array with the first 100 entries
wordCounts.take(100)

//como no es grande, puedo forzar toda la coleccion a una lista / because is not big, I can force the whole collection to a list
wordCounts.collect

//la palabra mas usada / the most used word
wordCounts.reduce((a, b) => if (a._2 > b._2) a else b)

//top 10
wordCounts.keyBy(_._2).sortByKey(ascending=false).take(10)
