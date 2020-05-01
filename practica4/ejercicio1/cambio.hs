
				
monedas :: Int -> [Int]->[Int]
monedas n [] = []
monedas 0 xs = []
monedas n (x:xs) | x <= n = x : monedas (n-x) (x:xs) 
                 | x > n = monedas n xs 

              
				   
				
	
