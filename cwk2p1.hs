---------------------------------------------------------------
-- Language Engineering: COMS22201
-- CWK2p1: Denotational Semantics of Arithmetics and Booleans
-- Due: Sunday 6th March (for formative feedback only)
---------------------------------------------------------------
-- This stub file provides a set of Haskell type definitions
-- that you should use to implement six functions associated 
-- with the denotational semantics of arithmetic and Boolean 
-- expressions in the While programming language as described 
-- in the course text book by Nielson and Nielson.
--
-- These six functions are defined in the lecture notes and 
-- in Chapter 1 of the book. Hints on their implementation 
-- can be found in the lab exercises and the Miranda code 
-- in Appendix B of the book.
--
-- You should submit one file "cwk2p1.hs" into the "CWK2p1"
-- unit component in SAFE by midnight on Sunday 6th March.
--
-- You should ensure your file loads in GHCI with no errors 
-- and it does not import any modules (other than Prelude).
--
-- Please note that your submission will NOT be marked if 
-- it is late, incorrectly named, generates load errors, 
-- or if you modify any of the type definitions below.
---------------------------------------------------------------
  
import Prelude hiding (Num)
import qualified Prelude (Num)

type Num = Integer
type Var = String
type Z = Integer
type T = Bool
type State = Var -> Z

data Aexp = N Num | V Var | Add Aexp Aexp | Mult Aexp Aexp | Sub Aexp Aexp deriving (Show, Eq, Read)
data Bexp = TRUE | FALSE | Eq Aexp Aexp | Le Aexp Aexp | Neg Bexp | And Bexp Bexp deriving (Show, Eq, Read)
data Stm  = Ass Var Aexp | Skip | Comp Stm Stm | If Bexp Stm Stm | While Bexp Stm deriving (Show, Eq, Read)

---------------------------------------------------------------
-- QUESTION 1)
-- Write a function fv_aexp with the following signature such that 
-- fv_aexp a returns the set of (free) variables in a:  
---------------------------------------------------------------

a = Mult ( Add (V "x") (V "x") ) ( Sub (V "z") (N 1) )

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
---------------------------------------------------------------
-- QUESTION 2)
-- Write a function fv_bexp with the following signature such that 
-- fv_bexp b returns the set of (free) variables in b:  
---------------------------------------------------------------

fv_bexp :: Bexp -> [Var]
fv_bexp b = rem_dup (fv_bexp_help b)
    where   fv_bexp_help TRUE = []
            fv_bexp_help FALSE = []
            fv_bexp_help (Eq a1 a2) = fv_aexp a1 ++ fv_aexp a2
            fv_bexp_help (Le a1 a2) = fv_aexp a1 ++ fv_aexp a2
            fv_bexp_help (Neg b) = fv_bexp b
            fv_bexp_help (And b1 b2) = fv_bexp b1 ++ fv_bexp b2

---------------------------------------------------------------
-- QUESTION 3)
-- Write a function subst_aexp with the following signature such that 
-- subst_aexp a1 v a2 returns the result of replacing all occurences of v in a1 by a2:
---------------------------------------------------------------

subst_aexp :: Aexp -> Var -> Aexp -> Aexp
subst_aexp (N a1) v a2 = N a1
subst_aexp (V a1) v a2
    | a1 == v = a2
    | otherwise = V a1
subst_aexp (Add a11 a12) v a2 = Add (subst_aexp a11 v a2) (subst_aexp a12 v a2)
subst_aexp (Mult a11 a12) v a2 = Mult (subst_aexp a11 v a2) (subst_aexp a12 v a2)
subst_aexp (Sub a11 a12) v a2 = Sub (subst_aexp a11 v a2) (subst_aexp a12 v a2)

---------------------------------------------------------------
-- QUESTION 4)
-- Write a function subst_bexp with the following signature such that 
-- subst_bexp b v a returns the result of replacing all occurences of v in b by a:
---------------------------------------------------------------

subst_bexp :: Bexp -> Var -> Aexp -> Bexp 
subst_bexp TRUE _ _ = TRUE
subst_bexp FALSE _ _ = FALSE
subst_bexp (Eq a11 a12) v a2 = Eq (subst_aexp a11 v a2) (subst_aexp a12 v a2)
subst_bexp (Le a11 a12) v a2 = Le (subst_aexp a11 v a2) (subst_aexp a12 v a2)
subst_bexp (Neg b1) v b2 = Neg (subst_bexp b1 v b2)
subst_bexp (And b11 b12) v a2 = And (subst_bexp b11 v a2) (subst_bexp b12 v a2)

---------------------------------------------------------------
-- QUESTION 5)
-- Write a function a_val with the following signature such that
-- a_val a s returns the result of semantically evaluating expression a in state s:
---------------------------------------------------------------

a_val :: Aexp -> State -> Z
a_val (V v) s           = s v
a_val (N n) _           = n
a_val (Add a1 a2) s     = a_val a1 s + a_val a2 s
a_val (Mult a1 a2) s    = a_val a1 s * a_val a2 s
a_val (Sub a1 a2) s     = a_val a1 s - a_val a2 s

---------------------------------------------------------------
-- QUESTION 6)
-- Write a function b_val with the following signature such that
-- b_val b s returns the result of semantically evaluating expression b in state s:
---------------------------------------------------------------

b_val :: Bexp -> State -> T
b_val TRUE _ = True
b_val FALSE _ = False
b_val (Eq a1 a2) s  = (a_val a1 s) == (a_val a2 s)
b_val (Le a1 a2) s  = (a_val a1 s) <= (a_val a2 s)
b_val (Neg b) s     = not (b_val b s)
b_val (And b1 b2) s = (b_val b1 s) && (b_val b2 s)


