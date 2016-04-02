---------------------------------------------------------------
-- Language Engineering: COMS22201
-- Assessed Coursework 2: CWK2
-- Question 1: Denotational Semantics of While with read/write
---------------------------------------------------------------
-- This stub file provides a set of Haskell type definitions
-- you should use to implement various functions and examples 
-- associated with the denotational semantics of While with 
-- read and write statements as previously used in CWK1.
-- 
-- To answer this question, upload one file "cwk2.hs" to the 
-- "CWK2" unit component in SAFE by midnight on 01/05/2016.
--
-- You should ensure your file loads in GHCI with no errors 
-- and it does not import any modules (other than Prelude).
--
-- Please note that you will loose marks if your submission 
-- is late, incorrectly named, generates load errors, 
-- or if you modify any of the type definitions below.
--
-- For further information see the brief at the following URL:
-- https://www.cs.bris.ac.uk/Teaching/Resources/COMS22201/cwk2.pdf
---------------------------------------------------------------

import Prelude hiding (Num)
import qualified Prelude (Num)
  
type Num = Integer
type Var = String
type Z = Integer
type T = Bool
type State = Var -> Z
type Input  = [Integer]  -- to denote the values read by a program
type Output = [String]   -- to denote the strings written by a program
type IOState = (Input,Output,State)  -- to denote the combined inputs, outputs and state of a program

data Aexp = N Num | V Var | Add Aexp Aexp | Mult Aexp Aexp | Sub Aexp Aexp deriving (Show, Eq, Read)
data Bexp = TRUE | FALSE | Eq Aexp Aexp | Le Aexp Aexp | Neg Bexp | And Bexp Bexp deriving (Show, Eq, Read)
data Stm  = Ass Var Aexp | Skip | Comp Stm Stm | If Bexp Stm Stm | While Bexp Stm 
          | Read Var       -- for reading in the value of a variable
          | WriteA Aexp    -- for writing out the value of an arithmetic expression
          | WriteB Bexp    -- for writing out the value of a Boolean expression
          | WriteS String  -- for writing out a given string
          | WriteLn        -- for writing out a string consisting of a newline character
          deriving (Show, Eq, Read)

---------------------------------------------------------------
-- Part A)
--
-- Begin by adding your definitions of the following functions
-- that you previously wrote as part of CWK2p1 and CWk2p2:
---------------------------------------------------------------

fv_aexp :: Aexp -> [Var]
fv_aexp a = rem_dup (fv_aexp_help a)
    where   fv_aexp_help (N n) = []
            fv_aexp_help (V x) = [x]
            fv_aexp_help (Add a1 a2) = fv_aexp_help a1 ++ fv_aexp_help a2
            fv_aexp_help (Mult a b) = fv_aexp_help a ++ fv_aexp_help b
            fv_aexp_help (Sub a b) = fv_aexp_help a ++ fv_aexp_help b

rem_dup :: [Var] -> [Var]
rem_dup [] = [] 
rem_dup (x:xs)
    | x `elem` xs = rem_dup xs
    | otherwise = x:(rem_dup xs)

fv_bexp :: Bexp -> [Var]
fv_bexp b = rem_dup (fv_bexp_help b)
    where   fv_bexp_help TRUE = []
            fv_bexp_help FALSE = []
            fv_bexp_help (Eq a1 a2) = fv_aexp a1 ++ fv_aexp a2
            fv_bexp_help (Le a1 a2) = fv_aexp a1 ++ fv_aexp a2
            fv_bexp_help (Neg b) = fv_bexp b
            fv_bexp_help (And b1 b2) = fv_bexp b1 ++ fv_bexp b2

a_val :: Aexp -> State -> Z
a_val (V v) s           = s v
a_val (N n) _           = n
a_val (Add a1 a2) s     = a_val a1 s + a_val a2 s
a_val (Mult a1 a2) s    = a_val a1 s * a_val a2 s
a_val (Sub a1 a2) s     = a_val a1 s - a_val a2 s

b_val :: Bexp -> State -> T
b_val TRUE _ = True
b_val FALSE _ = False
b_val (Eq a1 a2) s  = (a_val a1 s) == (a_val a2 s)
b_val (Le a1 a2) s  = (a_val a1 s) <= (a_val a2 s)
b_val (Neg b) s     = not (b_val b s)
b_val (And b1 b2) s = (b_val b1 s) && (b_val b2 s)


cond :: (a->T, a->a, a->a) -> (a->a)
cond (b, p, q) s
    | b s = p s
    | otherwise = q s

fix :: (a -> a) -> a
fix f = f (fix f)

update :: State -> Z -> Var -> State
update s i v x
    | v == x = i
    | otherwise = s x
---------------------------------------------------------------
-- Part B))
--
-- Write a function fv_stm with the following signature such that 
-- fv_stm p returns the set of (free) variables appearing in p:  
---------------------------------------------------------------

fv_stm :: Stm -> [Var]

---------------------------------------------------------------
-- Part C)
--
-- Define a constant fac representing the following program 
-- (which you may recall from the file test7.w used in CWK1):
{--------------------------------------------------------------
write('Factorial calculator'); writeln;
write('Enter number: ');
read(x);
write('Factorial of '); write(x); write(' is ');
y := 1;
while !(x=1) do (
  y := y * x;
  x := x - 1
);
write(y);
writeln;
writeln;
---------------------------------------------------------------}

fac :: Stm

---------------------------------------------------------------
-- Part D)
--
-- Define a constant pow representing the following program 
-- (which you may recall from the file test7.w used in CWK1):
{--------------------------------------------------------------
write('Exponential calculator'); writeln;
write('Enter base: ');
read(base);
if 1 <= base then (
  write('Enter exponent: ');
  read(exponent);
  num := 1;
  count := exponent;
  while 1 <= count do (
    num := num * base;
    count := count - 1
  );
  write(base); write(' raised to the power of '); write(exponent); write(' is ');
  write(num)
) else (
  write('Invalid base '); write(base)
);
writeln
---------------------------------------------------------------}

pow :: Stm

---------------------------------------------------------------
-- Part E)
--
-- Write a function s_ds with the following signature such that 
-- s_ds p (i,o,s) returns the result of semantically evaluating 
-- program p in state s with input list i and output list o.
---------------------------------------------------------------

s_ds :: Stm -> IOState -> IOState

---------------------------------------------------------------
-- Part F)
--
-- Write a function eval with the following signature such that 
-- eval p (i,o,s) computes the result of semantically evaluating 
-- program p in state s with input list i and output list o; and 
-- then returns the final input list and output list together 
-- with a list of the variables appearing in the program and 
-- their respective values in the final state.
---------------------------------------------------------------

eval :: Stm -> IOState -> (Input, Output, [Var], [Num])

