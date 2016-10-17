package main

import (
	"fmt"
	"strings"
)

func swapRune(r rune) rune {
	return r ^ ' '
}

func main() {
	var s string
	fmt.Scanln(&s)
	if strings.ToUpper(s[1:]) == s[1:] {
		s = strings.Map(swapRune, s)
	}
	fmt.Println(s)
}
