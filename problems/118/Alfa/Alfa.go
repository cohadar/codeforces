package main 

import (
	"fmt"
	"strings"
)

func main() {
	var in string
	fmt.Scanln(&in)
	var out string
	for _, c := range in {
		if strings.ContainsRune("aeiouy", c | ' ') {
			// skip
		} else {
			out += "."
			out += string(c | ' ')
		}
	}
	fmt.Println(out)
}