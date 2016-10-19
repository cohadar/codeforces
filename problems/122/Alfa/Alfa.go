package main

import "fmt"

func lucky(n int) bool {
	if n < 10 {
		if n == 4 || n == 7 {
			return true
		} else {
			return false
		}
	} else {
		return lucky(n % 10) && lucky(n / 10)
	}
}

func almostLucky(n int) bool {
	for i := 2; i <= n; i++ {
		if lucky(i) && n % i == 0 {
			return true
		}
	}
	return false
}

func main() {
	var n int
	fmt.Scan(&n)
	almost := "NO"
	if almostLucky(n) {
		almost = "YES"
	}
	fmt.Println(almost)
}

