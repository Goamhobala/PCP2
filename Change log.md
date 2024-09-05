* Changed arrived/inStadium in PeopleLocation to AtomicBoolean, shouldn;t have since ppl location is actually position of 1 person only
* I suspect that there's a race condition in stadiumGrid is shared amongst all the swimmer threads => race condition 
	* synchronised enterStadium => deadlock, nobody appears
	* Shouldn't have since enterStadium is not actually making changes to the Grid, but simply returning a block object and setting location of that swimmer to entrance
* Changed isOccupied in GridBlock to AtomicInteger, and now all swimmers are being generated properly. However, they'd all swim at the same time. This is done to ensure that the isOccupied value is up to date
* To make sure not all swimmers start swimming at the same time, implements a baton system using barrier, as barrier is reusable: Neither latches nor barriers is ideal. 
	* Temperarily fixed with spinning and passing baton
* Enforce order amongst threads: Forcing release lock once finished diving, pass back to swim team -> pass to next thread: 
	* Use atomicInteger as baton, and only swim if swimStroke == baton
	* Problem: If black don't enter first, can't get to the pool
		* Now I'm using sleep to temporarily address the issue, but could , maybe do the same as the baton?
* Make sure th