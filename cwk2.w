{------------------------------------------------------------
 -- Language Engineering: COMS22201
 -- Assessed Coursework 2: CWK2
 -- Question 3: Axiomatic Semantics of While with read/write
 ------------------------------------------------------------
 -- This stub file gives two code fragments (from the test7.w
 -- source file used in CWK1) that you will need to annotate
 -- with tableau correctness proofs using the partial axiomatic
 -- semantics extended with axioms for read/write statements.
 --
 -- To answer this question, upload one file "cwk2.w" to the
 -- "CWK2" unit component in SAFE by midnight on 01/05/2016.
 --
 -- For further information see the brief at the following URL:
 -- https://www.cs.bris.ac.uk/Teaching/Resources/COMS22201/cwk2.pdf
 ------------------------------------------------------------}


{------------------------------------------------------------
 -- Part A)
 --
 -- provide a tableau-based partial correctness proof
 -- of the following program (for computing factorials)
 -- with respect to the given pre- and post-conditions
 -- by completing the annotation of the program with
 -- logical formulae enclosed within curly braces:
 ------------------------------------------------------------}

{ head(IN)=n }
write('Factorial calculator'); writeln;
{ head{IN}=n }
write('Enter number: ');
{ head{IN}=n }
read(x);
{ x=n }
write('Factorial of '); write(x); write(' is ');
y := 1;
{y=1 & x=n}
{ x>0 -> n!=yx! }
while !(x=1) do (
  { x>0 -> n!=yx! & !(x=1) }
  {
    1. x>0 -> n!=yx! given
    2. (x-1)>0 assumed
    3. x>1 from 2 by addding 1 to both sides
    4. 1>0 by basic arithmetic
    5. x>0 by 3 and 4
    6. n!=yx! from 5 and 1 by -> elimination
    7. x!=x*(x-1)! by definition of ! using 5
    8. n!=y*x*(x-1)! sub 7 in 6
  }
  { (x-1)>0 -> n!=(y*x)(x-1)! & !(x=1) }
  y := y * x;
  { (x-1)>0 -> n!=y(x-1)! & !(x=1) }
  x := x - 1
  { x>0 -> n!=yx! }
);
{ x>0 -> n!=yx! & x=1 }
{
  1. x>0 -> n!=yx! given
  2. x=1 given
  3. 1>0 by basic arithmetic
  4. x>0 by 2 and 3
  5. n!=yx! from 4 and 1 by -> elimination
}
{ n!=yx! & x=1 }
{ y=n! }
{ append(OUT,[y])=append(OUT,[n!]) }
{ append(OUT,[y])=append(_,[n!]) }
write(y);
{ OUT=append(_,[n!]) }
{ append(OUT,['\n'])=append(_,[n!,'\n']) }
writeln;
{ OUT=append(_,[n!,'\n']) }
{ append(OUT,['\n'])=append(_,[n!,'\n','\n']) }
writeln;
{ OUT=append(_,[n!,'\n','\n'])}
{ OUT=append(_,[n!,_,_]) }


{------------------------------------------------------------
 -- Part B)
 --
 -- provide a tableau-based partial correctness proof
 -- of the following program (for computing exponents)
 -- with respect to suitable pre- and post-conditions:
 ------------------------------------------------------------}

{ IN=[b,e] & 1<=b & 1<=e }
write('Exponential calculator'); writeln;

write('Enter base: ');
{ IN=append(b,[e]) & 1<=b & 1<=e }
{ head(IN)=b & tail(IN)=[e] & 1<=b & 1<=e }
read(base);
{ base=b & IN=[e] & 1<=b & 1<=e }
{ 1<=base & IN=[e] }
if 1 <= base then (
  { 1<=base & IN=[e] & base=b & 1<=e }
  write('Enter exponent: ');
  { IN=append(e,[]) & base=b & 1<=e }
  { head(IN)=e & tail(IN)=[] & base=b & 1<=e }
  read(exponent);
  { exponent=e & IN=[] & base=b & 1<=e }
  { 1<=exponent & base=b & exponent=e }

  num := 1;
  { 1<=exponent & exponent=e & base=b & num=1 }
  count := exponent;
  { 1<=exponent & exponent=e & base=b & num=1 & count=exponent}
  { base^exponent=num*base^count & 1<=count } //Maybe replace base^exponent with b^e
  { base^exponent=num*base^count & 0<=count }
  while 1 <= count do (
    { base^exponent=num*base^count & 1<=count & 0<=count }
    { base^exponent=(num*base)*base^(count-1) & 1<=count & 0<=count}
    num := num * base;
    { base^exponent=num*base^(count-1) & 1<=count & 0<=count }
    { base^exponent=num*base^(count-1) & 0<=(count-1) }
    count := count - 1
    { base^exponent=num*base^count & 0<=count }
  );
  { base^exponent=num*base^count & 0<=count & ¬(1<=count) }
  { base^exponent=num*base^count & count=0 }
  { base^exponent=num & count=0 }
  { num=b^e }
  write(base);
  { num=b^e }
  write(' raised to the power of ');
  { num=b^e }
  write(exponent);
  { num=b^e }
  write(' is ');
  { num=b^e }
  { append(OUT,[num])=append(_,[b^e]) }
  write(num)
  { OUT=append(_,[b^e]) }
) else (
  { 1<=base & ¬(1<=base) }
  { false }
  write('Invalid base ');
  { false }
  { append(OUT,[b^e])=append(_,[b^e])}
  write(base)
  { OUT=append(_,[b^e]) }
);
{ OUT=append(_,[b^e]) }
{ append(OUT,['\n'])=append(_,[b^e,'\n']) }
writeln
{ OUT=append(_,[b^e,'\n']) }
{ OUT=append(_,[b^e,_]) }
