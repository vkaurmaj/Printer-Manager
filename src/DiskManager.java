// DiskManager.java


public class DiskManager {
	
	
    boolean isFree[];
    
    	// DiskManager gets access to our array of disks and makes sure that one 
    	// user writes to it at a time per disk
    DiskManager(int numberOfItems)
    {
            isFree = new boolean[numberOfItems];
            for (int i=0; i<isFree.length; ++i)
                    isFree[i] = true;
    }
    synchronized int request() throws InterruptedException
    {
            while (true)
            {
                    for (int i = 0; i < isFree.length; ++i)
                            if ( isFree[i] )
                            {
                                    isFree[i] = false;
                                    return i;
                            }
                    this.wait(); // block until someone releases a Resource
            }
    }
    synchronized void release( int index )
    {
            isFree[index] = true;
            this.notify(); // let a waiting thread run
    }
    
	public int nextAvail(int index) {
		Disk disk = mainClass.disks[index];
		for (int j = 0; j < disk.NUM_OF_SECTORS; j++) {
			if (disk.sectors[j] == null) {
				return j;
			}
		}
		
		return -1;
	}
	
	
};