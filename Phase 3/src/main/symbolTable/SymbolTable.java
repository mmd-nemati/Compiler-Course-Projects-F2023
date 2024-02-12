package main.symbolTable;

import main.symbolTable.itemException.*;
import main.symbolTable.symbolTableItems.SymbolTableItem;

import java.util.HashMap;

public class SymbolTable {

	// Static members region
		public static SymbolTable top;
		public static SymbolTable root;
		private static Stack<SymbolTable> stack = new Stack<SymbolTable>();
		public static void push(SymbolTable symbolTable) {
			if(top != null)
				stack.push(top);
			top = symbolTable;
		}

		public static void pop() {
		top = stack.pop();
	}

	public SymbolTable pre;
	public String name;
	private HashMap<String, SymbolTableItem> items;


	public SymbolTable() {
		this(null, "");
	}

	public SymbolTable(SymbolTable pre, String name) {
		this.pre = pre;
		this.items = new HashMap<>();
		this.name = name;
	}

	public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
		if(items.containsKey(item.getKey()))
			throw new ItemAlreadyExistsException();
		items.put(item.getKey(), item);
	}

	public SymbolTableItem get(String key) throws ItemNotFoundException {
		SymbolTableItem item = items.get(key);
		if(item == null && pre != null)
			return pre.get(key);
		else if(item == null)
			throw new ItemNotFoundException();
		else
			return item;
	}
}