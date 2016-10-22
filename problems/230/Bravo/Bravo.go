package main

//import "fmt"
import "math"
import "os"
import "bufio"
import "strconv"

var Sieve []bool

func tPrime(a int64) bool {
	if a == 1 {
		return false
	}
	r := int64(math.Sqrt(float64(a)))
	return r * r == a && Sieve[int(r)]
}

func sieve(n int) []bool {
	sieve := make([]bool, n)
	sieve[2] = true
	for i := 3; i < n; i += 2 {
		sieve[i] = true
	}
	for i := 2; i * i <= n; i++ {
		if sieve[i] {
			for j := i * i; j < n; j += i {
				sieve[j] = false
			}
		}
	}
	return sieve
}

func main() {
	fastio := NewFastIO()
	Sieve = sieve(1e6 + 1)	
	n := fastio.NextInt()	
	for i := 0; i < n; i++ {
		a := fastio.NextInt64()
		if tPrime(a) {
			fastio.WriteString("YES\n")
		} else {
			fastio.WriteString("NO\n")
		}
	}
	fastio.Flush()
}

//=========================
// FastIO
//=========================
type FastIO struct {
	*bufio.Writer
	scanner *bufio.Scanner
}

func NewFastIO() *FastIO {
	ret := new(FastIO)
	ret.scanner = bufio.NewScanner(os.Stdin)
	ret.scanner.Split(bufio.ScanWords)	
	ret.Writer = bufio.NewWriter(os.Stdout)
	return ret
}

func (p *FastIO) NextInt() int {
	p.scanner.Scan()
	a, _ := strconv.ParseInt(p.scanner.Text(),10,64)
	return int(a)
}

func (p *FastIO) NextInt64() int64 {
	p.scanner.Scan()
	a, _ := strconv.ParseInt(p.scanner.Text(),10,64)
	return a
}
