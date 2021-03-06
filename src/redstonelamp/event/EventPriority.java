package redstonelamp.event;

public enum EventPriority {
	LOWEST(0),
	LOW(1),
	NORMAL(2),
	HIGH(3),
	HIGHEST(4),
	MONITOR(5);
	
	private final int slot;
	
	private EventPriority(int slot) {
		this.slot = slot;
	}
	
	/**
	 * Returns the slot integer
	 * 
	 * @return int
	 */
	public int getSlot() {
		return slot;
	}
}
