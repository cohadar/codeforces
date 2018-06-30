package main

import "os"
import "bufio"
import "fmt"

func main() {
	var n, prev, curr int
	in := bufio.NewReader(os.Stdin)
	fmt.Fscan(in, &n)
	max, cmax := 1, 0
	for i := 0; i < n; i++ {
		fmt.Fscan(in, &curr)
		if curr >= prev {
			cmax++
			if cmax > max {
				max = cmax
			}
		} else {
			cmax = 1
		}
		prev = curr
	}
	fmt.Println(max)
}
