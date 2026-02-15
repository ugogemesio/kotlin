package com.example.kotlin.java_resource;
import com.example.kotlin.module2.Crau;
import com.example.kotlin.module2.*;

public class JavaResource {
    EFunctions eFunctions;

    KExtension kExtension;
    char c = kExtension.lastChar("abc");

    void callKotlin(){
        eFunctions = new EFunctions();
        Crau.foo();
        eFunctions.foo();
        Crau.another();
    }
    void callJavaResource(){
        JavaResourceTwo.teste();
        //error down below - remembering the static use
        //JavaResourceTwo.teste2();
    }
}
