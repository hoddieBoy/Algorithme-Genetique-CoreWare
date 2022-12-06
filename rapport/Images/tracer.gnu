set terminal png

set output 'croissance.png'

plot 'croissance.dat' using 1:2 w l
