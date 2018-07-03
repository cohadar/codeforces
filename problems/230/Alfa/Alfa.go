package main

import "fmt"
import "sort"

type dragon struct {
	strength, bonus int
}

type dragonSlice []dragon

func (o dragonSlice) Len() int {
	return len(o)
}

func (o dragonSlice) Less(i, j int) bool {
	return o[i].strength < o[j].strength
}

func (o dragonSlice) Swap(i, j int) {
	o[i], o[j] = o[j], o[i]
}

func main() {
	var s, n int
	fmt.Scan(&s, &n)
	d := make([]dragon, n)
	for i := range d {
		fmt.Scan(&d[i].strength, &d[i].bonus)
	}
	sort.Sort(dragonSlice(d))
	for _, v := range d {
		if s <= v.strength {
			fmt.Println("NO")
			return
		}
		s += v.bonus
	}
	fmt.Println("YES")
}
