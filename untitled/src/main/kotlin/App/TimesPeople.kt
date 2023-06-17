package App

class TimesPeople {
    val listTimesPeople = hashSetOf<String>()

    fun main(): HashSet<String> {
        while(true) {
            print("Digite o time ou pessoa: ")
            var response = readlnOrNull()

            if (response != null) {
                listTimesPeople.add(response)
                println("O time foi cadastrado!")
            }

            if (response == null) {
                println("Digite o nome do time ou pessoa!")
                continue
            }

            print("Quer acrescentar outro time? [s/n]: ")
            response = readLine()

            if (response == "s") {
                continue
            } else {
                if (listTimesPeople.size < 2) {
                    println("Me desculpe, mas não podemos aceitar apenas 1 time ou pessoa para ser apostado!")
                    println("Acrescente outro!")
                    continue
                } else {
                    return listTimesPeople
                    break
                }
            }
        }
    }

    fun winner(listTimesPeople: HashSet<String>): String {
        println("Times")
        for (time in listTimesPeople) {
            println(time)
        }

        while (true) {
            print("Vencedor: ")
            val win = readlnOrNull()
            if (win == null) {
                println("Me desculpa, mas digite o time vencedor!")
                continue
            }

            if (win !in listTimesPeople) {
                println("Por favor, digite um time dos apresentados acima!")
                continue
            }

            return win
        }




    }
}