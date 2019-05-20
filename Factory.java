package com.zh.reflect;


        interface Clothes{
            void wear();
        }
        class Shirt implements Clothes{
            @Override
            public void wear() {
                System.out.println("穿衬衫");
            }
        }
        class Skirt implements Clothes{

            @Override
            public void wear() {
                System.out.println("穿短袖");
            }
        }
        class Pants implements Clothes{

            @Override
            public void wear() {
                System.out.println("穿牛仔裤");
            }
        }
        class ClothesFactory{
            private ClothesFactory(){

            }
            public static Clothes getClothesInstance(String className){  //工厂返回的是接口类型
                //new->具体类型耦合
                try{
                    Class class1=Class.forName(className);
                    return (Clothes)class1.newInstance();  //获取实例化对象
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("Factory生产不了"+className);
            }
        }
public class Factory {
        public static void main(String[] args) {
            Clothes clothes=ClothesFactory.getClothesInstance("com.zh.reflect.Skirt");
            clothes.wear();
        }
    }














