//package com.twb.readfile
//
//import java.io.File
//import java.io.InputStream
//import java.nio.charset.Charset
//
//class ReadFile{
//
//
//    fun readfileBuffer(filename: String) {
//        val file = File(filename) //"test_readfile.txt"
//        val bufferedReader = file.bufferedReader()
//        val text = bufferedReader.readLines()
//        println("\n\tRead as Buffer")
//        for(line in text){
//            println(line)
//        }
//    }
//
//    /**
//     * Created by www.tutorialkart.com
//     * Example program to read contents of a file in Kotlin line by line
//     */
//    fun readSimple(filename: String) {
//        val file = File(filename)
//        println("\n\tRead as Simple")
//        file.forEachLine { println(it) }
//    }
//
//    /**
//     * Created by www.tutorialkart.com
//     * Example program to read contents of a file in Kotlin to InputStream
//     */
//    fun readFileInputStream(filename: String) {
//        val file = File(filename)
//        var ins:InputStream = file.inputStream()
//        // read contents of IntputStream to String
//        println("\n\tRead as IntputStream")
//        var content = ins.readBytes().toString(Charset.defaultCharset())
//        println(content)
//    }
//
//
//    fun readFileList(filename: String) {
//        val file = File(filename)
//        var lines:List<String> = file.readLines()
//        println("\n\tRead as List")
//        for(line in lines){
//            println(line)
//        }
//    }
//
//    fun readFileText(filename: String) {
//        val file = File(filename)
//
//        println("\n\tRead as Text")
//        var content:String = file.readText()
//        println(content)
//    }
//
//}
//
//fun main(args: Array<String>){
//
//    val readClass = ReadFile()
////    val filename = "test_readfile.txt"
//    val filename = "animescsv.csv"
//
//    readClass.readfileBuffer(filename)
////    readClass.readFileInputStream(filename) // To avoid
////    readClass.readSimple(filename)
////    readClass.readFileList(filename)
////    readClass.readFileText(filename) // To avoid
//}