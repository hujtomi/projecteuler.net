using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEuler
{
    class Program
    {
        static void Main(string[] args)
        {
            new Program();
            Console.ReadKey();
        }

        public Program()
        {
            problem24();
        }

        public int problem1()
        {
            Console.WriteLine("devidable numbers");
            List<int> devidableNumbers = new List<int>();

            for (int i = 0; i < 1000; i++)
            {
                if (i % 3 == 0 || i % 5 == 0)
                {
                    devidableNumbers.Add(i);
                }
            }

            return devidableNumbers.Sum();
        }

        public int problem2()
        {
            Console.WriteLine("fibonacci even sum");
            List<int> fibonacciItems = new List<int>();
            fibonacciItems.Add(1);
            fibonacciItems.Add(2);

            while (fibonacciItems.ElementAt(fibonacciItems.Count() - 1) < 4000000)
            {
                int newitem = fibonacciItems.ElementAt(fibonacciItems.Count() - 1) + fibonacciItems.ElementAt(fibonacciItems.Count() - 2);
                fibonacciItems.Add(newitem);
            }

            fibonacciItems.Remove(fibonacciItems.Last());

            Console.WriteLine("last item: " + fibonacciItems.Last());

            return fibonacciItems.Where(item => item % 2 == 0).Sum();
        }

        public long problem3()
        {
            Console.WriteLine("largest prim factor");

            //long number = 600851475143;

            long number = 87625999;

            long largestDevider = 1;
            for (long i = 1; i < number; i = i + 2)
            {
                if (number % i == 0)
                {
                    Console.WriteLine("devider:" + i);
                    largestDevider = i;
                }
            }

            Console.WriteLine("largest devider: " + largestDevider);

            return largestDevider;
        }

        public void problem4()
        {
            int maxpal = 0;
            int maxi = 0;
            int maxj = 0;

            for (int i = 1000; i > 99; i--)
            {
                for (int j = 1000; j > 99; j--)
                {
                    int test = i * j;

                    char[] testchar = test.ToString().ToCharArray();
                    Array.Reverse(testchar);
                    string testReversed = new string(testchar);

                    if (test.ToString() == testReversed)
                    {
                        Console.WriteLine(string.Format("{0} * {1} = {2}", i, j, i * j));
                        if (i * j > maxpal)
                        {
                            maxpal = i * j;
                            maxi = i;
                            maxj = j;
                        }
                    }
                }
            }

            Console.WriteLine("maxi: " + maxi);
            Console.WriteLine("maxj: " + maxj);
            Console.WriteLine("maxpal: " + maxpal);
        }

        public void problem5()
        {
            for (int i = 20; i < int.MaxValue; i++)
            {

                bool evenlydivisible = true;
                for (int j = 1; j < 20; j++)
                {
                    if (i % j != 0)
                    {
                        evenlydivisible = false;
                        break;
                    }
                }

                if (evenlydivisible)
                {
                    Console.WriteLine("evenly divisible: " + i);
                    return;
                }
            }

            Console.WriteLine("finished");
        }

        List<long> pandigitalList = new List<long>();

        public long problem43()
        {

            String s = "0123456789";
            bool[] used = { false, false, false, false, false, false, false, false, false, false };
            permute(0, "", used, s);

            Console.WriteLine("result: ");
            return pandigitalList.Sum();
        }

        public void problem24()
        {
            
            String s = "0123456789";
            bool[] used = { false, false, false, false, false, false, false, false, false, false };
            permute2(0, "", used, s);
        }

        int permutationCounter = 0;
        void permute2(int level, String permuted,
                    bool[] used, String original)
        {
            int length = original.Length;
            if (level == length)
            {
                //Console.WriteLine("permutation: " + permuted);
                permutationCounter++;

                if (permutationCounter == 1000000) 
                {
                    Console.WriteLine("the millionth permutation: " + permuted);
                    return;
                }
            }
            else
            {
                for (int i = 0; i < length; i++)
                {
                    if (!used[i])
                    {
                        used[i] = true;
                        permute2(level + 1, permuted + original[i],
                           used, original);
                        used[i] = false;
                    }
                }
            }
        }

        void permute(int level, String permuted,
                    bool[] used, String original)
        {
            int length = original.Length;
            if (level == length)
            {
                if (Int32.Parse(permuted.Substring(1, 3)) % 2 == 0
                    && Int32.Parse(permuted.Substring(2, 3)) % 3 == 0
                    && Int32.Parse(permuted.Substring(3, 3)) % 5 == 0
                    && Int32.Parse(permuted.Substring(4, 3)) % 7 == 0
                    && Int32.Parse(permuted.Substring(5, 3)) % 11 == 0
                    && Int32.Parse(permuted.Substring(6, 3)) % 13 == 0
                    && Int32.Parse(permuted.Substring(7, 3)) % 17 == 0)
                {
                    Console.WriteLine("good pandigital: " + permuted);
                    pandigitalList.Add(long.Parse(permuted));
                }

            }
            else
            {
                for (int i = 0; i < length; i++)
                {
                    if (!used[i])
                    {
                        used[i] = true;
                        permute(level + 1, permuted + original[i],
                           used, original);
                        used[i] = false;
                    }
                }
            }
        }

    }
}
