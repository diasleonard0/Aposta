package App

class Players {
    val listPlayers = mutableMapOf<String, MutableList<String>>()

    fun main(listTimesPeople: HashSet<String>): MutableMap<String, MutableList<String>> {
        println("Cadastro de Apostas")

        while (true) {
            val listPlayer = mutableListOf<String>()

            print("Nome: ")
            val name = readlnOrNull()
            if (name == null) {
                println("Houve um problema com o nome, tente novamente!")
                continue
            }
            if (name in listPlayers.keys) {
                println("Me Desculpe, mas já existe esse nome cadastrado, tente outro!")
                continue
            }

            print("Time: ")
            val time = readlnOrNull()
            if (time == null) {
                println("Houve um problema com o time escolhido, tente novamente!")
                continue
            }
            if (time !in listTimesPeople) {
                println("Sinto muito, mas o time não foi encontrado!")
                println("Os times são:")
                for (t in listTimesPeople) {
                    println(t)
                }
                continue
            }

            print("Valor: ")
            val value = readlnOrNull()
            if (value == null) {
                println("Houve um problema com o valor digitado, tente novamente!")
                continue
            }
            val valueDouble = value?.toDoubleOrNull()
            if (valueDouble == null) {
                println("Infelizmente o valor não foi identificado, tente novamente!")
                continue
            }

            listPlayer.add(name)
            listPlayer.add(time)
            listPlayer.add(value)

            listPlayers[name] = listPlayer
            println("Aposta Adicionada!")

            while (true) {
                print("Outra Aposta? [s/n]: ")
                val r = readlnOrNull()
                if (r == null) {
                    println("Por favor digite 's' ou 'n'!")
                    continue
                } else if (r == "n") {
                    return listPlayers
                } else {
                    break
                }
            }
            continue


        }
    }
}