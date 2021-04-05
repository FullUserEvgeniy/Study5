package com.company;
class MyThread extends Thread{
    MyThread(String name){
        super(name);
    }
    public void run(){
        System.out.println(getName()+" - запуск");
        try {
            for (int count=0;count<10;count++){
                Thread.sleep(700);
                System.out.println(getName()+", счетчик: "+count);
            }
        }catch (InterruptedException exc) {
            System.out.println(getName()+" прерван на 700 мсек.");
        }
        show();
    }
    void show(){
        System.out.println("Завершение работы второго потока");
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println("Запуск основного потока.");
        MyThread mtr=new MyThread("Второй поток");
        mtr.start();
        for (int i=0;i<15;i++){
            System.out.println("Основной поток "+i);
            try {
                Thread.sleep(200);
            }catch (InterruptedException exc){
                System.out.println("Прерывание основного потока на 200 мсек.");
            }
        }
        System.out.println("Завершение работы основного потока");
    }
}
