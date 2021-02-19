import java.util.HashMap;
import java.util.*;


class Item {
	public int id;
	public int price;
	public String name;
	Item(int id, int price, String name){
		this.id = id;
		this.price = price;
		this.name = name;
	}
}

class Inventory {
	public HashMap<Integer,Integer> itemAmount = new HashMap<Integer,Integer>();
	public HashMap<Integer,Integer> itemPrice = new HashMap<Integer,Integer>();
	
	private void addAmount(int id){
		if(itemAmount.get(id)==null){
			itemAmount.put(id,1);
			return;
		}
		int amount = itemAmount.get(id);
		itemAmount.put(id, amount+1);
	}
	
	private void addPrice(int id, int price){
		itemPrice.put(id, price);
	}
	
	public void addToInventory(Item item){
		addAmount(item.id);
		addPrice(item.id,item.price);
	}
}

class Cart {
	public int total;
	private ArrayList<Integer> presentCart = new ArrayList<Integer>();
	public HashMap<Integer, Integer> cartPrice = new 
					HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> cartItem = new HashMap<Integer, Integer>();
	
	public String addItem(int id, int amountAdd, Inventory inventory){
		if(inventory.itemAmount.get(id) < amountAdd){
			
			return "Quantity not available";
		}
		if(cartItem.get(id)==null){
			cartItem.put(id, amountAdd);
		}
		else {
			cartItem.put(id, cartItem.get(id) + amountAdd);
		}
		if(cartPrice.get(id)==null){
			cartPrice.put(id, inventory.itemPrice.get(id)*amountAdd);
		}
		else{
			cartPrice.put(id, cartPrice.get(id)+(inventory.itemPrice.get(id)*amountAdd));
		}
		total = total + cartPrice.get(id);
		if(!presentCart.contains(id)){
			presentCart.add(id);
		}
		inventory.itemAmount.put(id, inventory.itemAmount.get(id) - amountAdd);
		return "Added to cart";
	}
	public String removeItem(int id, int amountRemove, Inventory inventory){
		if(!presentCart.contains(id)){
			return "Your cart does not have the item";
		}
		if(amountRemove > cartItem.get(id)){
			return "Not enough items";
		}
		if(amountRemove == cartItem.get(id)){
			cartItem.put(id, null);
			presentCart.remove(new Integer(id));
			inventory.itemAmount.put(id, inventory.itemAmount.get(id)+amountRemove);
			return "Cart updated successfully";
		}
		cartItem.put(id, cartItem.get(id)-amountRemove);
		cartPrice.put(id, cartPrice.get(id)-(inventory.itemPrice.get(id)*amountRemove));
		total = total - inventory.itemPrice.get(id)*amountRemove;
		inventory.itemAmount.put(id, inventory.itemAmount.get(id)+amountRemove);
		return "Cart updated successfully";
	}
	public void showCart(Inventory inventory){
		for(int i = 0; i<presentCart.size();i++){
			int currentItem = presentCart.get(i);
			System.out.println(currentItem+" "+inventory.itemAmount.get(currentItem)+ " "
					+ cartPrice.get(currentItem) + cartItem.get(currentItem));
			System.out.println("Total: "+total);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Item socks = new Item(1 , 30 , "Socks");
		Item pants = new Item(2 , 60 , "Pants");
		int count = 30;
		while(count!=0){
			inventory.addToInventory(socks);
			inventory.addToInventory(pants);
			count--;
		}
		System.out.println(socks.id+" "+socks.name+" "+socks.price+" "+inventory.itemAmount.get(socks.id));
		System.out.println(pants.id+" "+pants.name+" "+pants.price+" "+inventory.itemAmount.get(pants.id));
		System.out.println("");
		System.out.println("Press 1 to add item to cart");
		System.out.println("Press 2 to remove item from cart");
		System.out.println("Press 3 to view cart");
		System.out.println("Press 9 to exit");
		Cart cart = new Cart();
		int inputFromUser = 0;
		while(true){
			Scanner scanner = new Scanner(System.in);
			inputFromUser = scanner.nextInt();
			if(inputFromUser == 9){
				break;
			}
			if(inputFromUser == 1){
				System.out.println("Enter the item id and the amount to be added");
				int id = scanner.nextInt();
				int amount = scanner.nextInt();
				System.out.println(cart.addItem(id,amount,inventory));
				continue;
			}
			if(inputFromUser == 2){
				System.out.println("Enter the item id and the amount to be removed");
				int id = scanner.nextInt();
				int amount = scanner.nextInt();
				System.out.println(cart.removeItem(id,amount,inventory));
				continue;
			}
			if(inputFromUser == 3){
				cart.showCart(inventory);
			}
		}
	}

}
