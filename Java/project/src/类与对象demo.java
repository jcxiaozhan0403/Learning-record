public class Item{
    String name;
    int price;
    public static void main(String[] args){
        Item bottle = new Item();
        bottle.name = "血瓶";
        bottle.price = 50;

        Item shoes = new Item();
        shoes.name = "草鞋";
        shoes.price = 300;

        Item sword = new Item();
        sword.name = "长剑";
        sword.price = 350;

        void legendary(){
            System.out.println("超神");
        }
    
        float getHp(){
            return price;
        }
    
        void recovery(float blood){
            hp = hp +blood;
        }
    }
}