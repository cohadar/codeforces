package main

import "fmt"

func main() {
	var ny, nx int
	fmt.Scan(&ny, &nx)
	c0 := make([]byte, nx)
	c1 := make([]byte, nx)
	c3 := make([]byte, nx)
	for i := range c0 {
		c0[i] = '#'
		c1[i] = '.'
		c3[i] = '.'
	}
	c1[nx-1] = '#'
	c3[0] = '#'
	for y := 0; y < ny; y++ {
		switch y % 4 {
		case 1:
			fmt.Println(string(c1))
		case 3:
			fmt.Println(string(c3))
		default:
			fmt.Println(string(c0))
		}
	}
}
