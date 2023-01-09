package main


import(
	"fmt"
	"runtime"
	"time"

)

const(
	O = 1
	H20 = 8
)

type Empty struct{}

var counter = 0

func Ox(id int , done chan Empty, Chan chan Empty , ochan chan Empty){
	for i := 0; i<H20; i++{
		<-Chan
		<-Chan
		ochan <- Empty{}
		ochan <- Empty{}
		counter++
		fmt.Printf("%d H20 de %d\n",counter,H20)
	}
	fmt.Printf("L'oxigen %d ha acabat\n",id)
	done <- Empty{}
}

func Hi(id int , Chan chan Empty, ochan chan Empty){
	time.Sleep(8*time.Second)
	Chan <- Empty{}
	fmt.Printf("L'hidrogen %d ha acabat\n",id)
	<-ochan
	
}

func main(){
	runtime.GOMAXPROCS(O+H20*2)
	Chan := make(chan Empty)
	ochan := make(chan Empty)
	done := make(chan Empty, 1)

	for i := 0; i<O; i++{
		go Ox(i,done,Chan,ochan)
	}

	for i := O; i<O+H20*2; i++{
		go Hi(i,Chan, ochan)
	}

	for i := 0; i<O; i++{
		<-done
	}

	fmt.Printf("Counter value: %d Expected: %d\n", counter, H20)
}