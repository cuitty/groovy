package main.groovy

/**
 * Created by Dzianis Padbiarezski
 */

//def process = ['mysql', '-ubole -pbole'].execute();
//process.with {proc -> waitFor()}
//println process.text

//String output = new StringWriter().with { writer ->
//    [
//            'mysql',
//            '-h', 'localhost',
//            '-ubole',
//            '-pbole',
////            '-e', 'select * from bole.modx_active_users'
//    ].execute().with { proc ->
//        consumeProcessOutput( writer, writer )
////        waitFor()
//    }
//    writer.toString()
//}

//println output

def dir = new File("../../../../sql");
//println dir.listFiles()

def comm = ['cmd', '/c', 'mysql',
'-h', 'localhost',
'-uroot',
'-proot',
//'wl_v1112',
//'-e', 'source ' << file.canonicalPath
]

//for (file in dir.listFiles()){
//   comm << '-e';
//    comm << 'source ' + file.canonicalPath
// }
//         print comm;

String cr = new StringWriter().with { writer ->
    [     'cmd', '/c', 'mysql',
            '-h', 'localhost',
            '-uwl_v1112',
            '-pwl_v1112',
//                'wl_v1112',
//                '-e', 'USE `wl_v1112`',
            '-e', 'CREATE DATABASE /*!32312 IF NOT EXISTS*/ `wl_v1112` /*!40100 DEFAULT CHARACTER SET utf8 */'
    ].execute().with { proc ->
        consumeProcessOutput( writer, writer )
        waitFor()
    }
    writer.toString()
}
println cr

for (file in dir.listFiles()){
    String log = new StringWriter().with { writer ->
        [     'cmd', '/c', 'mysql',
                '-h', 'localhost',
                '-uwl_v1112',
                '-pwl_v1112',
                'wl_v1112',
//                '-e', 'USE `wl_v1112`',
                '-e', 'source ' << file.canonicalPath
        ].execute().with { proc ->
            consumeProcessOutput( writer, writer )
            waitFor()
        }
        writer.toString()
     }
     println log
}
//def process1 = ['mysql',  'select * from bole.modx_active_users'].execute()
//        process1.with {proc -> waitFor()}
//process1.text.eachLine {println it}
//def process3 = "cmd /c exit".execute()
//process3.text.eachLine {println it}
