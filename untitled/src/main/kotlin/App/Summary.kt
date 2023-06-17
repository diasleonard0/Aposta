package App

class Summary {
    fun main(listPlayers: MutableMap<String, MutableList<String>>, winner: String) {
        val listWinners: MutableMap<String, MutableList<String>> = mutableMapOf<String, MutableList<String>>()
        val listLosers = mutableMapOf<String, MutableList<String>>()

        // Verifica e separa conforme a lista de ganhador ou perdedor
        for (player in listPlayers.keys) {
            val listPlayer = mutableListOf<String>()
            val list = listPlayers[player]
            val time = list?.get(1)

            if (time == winner) {
                listPlayer.add(list[0])
                listPlayer.add(list[1])
                listPlayer.add(list[2])

                listWinners[list[0]] = listPlayer
            } else {
                listPlayer.add(list!![0])
                listPlayer.add(list[1])
                listPlayer.add(list[2])

                listLosers[list[0]] = listPlayer
            }
        }

        // Tabela com os ganhadores
        tableWinners(listWinners)

        // Tabela com os perdedores
        tableLosers(listLosers)

        // Meus ganhos
        tableMyEarnings(listWinners, listLosers)
    }

    private fun tableWinners(listWinners: MutableMap<String, MutableList<String>>) {
        println("╔══════════════════════════════════════════════════════════════════════╗")
        println("║                         Tabela de Ganhadores                         ║")
        println("╠══════════════════════════════════════════════════════════════════════╣")
        println("║  Nome do Jogador  |     Time    |    Valor Apostado  |  Valor Ganho  ║")
        println("╠═══════════════════╪═════════════╪════════════════════╪═══════════════╣")

        for ((_, data) in listWinners) {
            val playerName = data[0]
            val time = data[1]
            val valorApostado = data[2].toDouble()
            val valorGanho = data[2].toDouble() * 2

            val player = playerName.padEnd(18)
            val timee = time.padEnd(12)
            val valorA = String.format("%.2f", valorApostado).padEnd(19)
            val valorG = String.format("%.2f", valorGanho).padEnd(14)

            println("║ $player| $timee| $valorA| $valorG║")
        }

        println("╚═══════════════════╪═════════════╪════════════════════╪═══════════════╝")
    }

    private fun tableLosers(listLosers: MutableMap<String, MutableList<String>>) {
        println("╔══════════════════════════════════════════════════════════════════════╗")
        println("║                         Tabela de Perdedores                         ║")
        println("╠══════════════════════════════════════════════════════════════════════╣")
        println("║  Nome do Jogador  |     Time    |   Valor Apostado   | Valor Perdido ║")
        println("╠═══════════════════╪═════════════╪════════════════════╪═══════════════╣")

        for ((_, data) in listLosers) {
            val playerName = data[0]
            val time = data[1]
            val valorApostado = data[2].toDouble()

            val player = playerName.padEnd(18)
            val timee = time.padEnd(12)
            val valorA = String.format("%.2f", valorApostado).padEnd(19)
            val valorB = String.format("%.2f", valorApostado).padEnd(14)

            println("║ $player| $timee| $valorA| $valorB║")
        }

        println("╚═══════════════════╪═════════════╪════════════════════╪═══════════════╝")
    }

    private fun tableMyEarnings(listWinners: MutableMap<String, MutableList<String>>, listLosers: MutableMap<String, MutableList<String>>) {
        var totalPerdido = 0.0
        var totalGanho = 0.0

        for ((_, data) in listWinners) {
            totalPerdido += data[2].toDouble() * 2
        }

        for ((_, data) in listLosers) {
            totalGanho += data[2].toDouble()
        }

        val total = totalGanho - totalPerdido

        val valorGanho = String.format("%.2f", totalGanho).padEnd(14)
        val valorPerdido = String.format("%.2f", totalPerdido).padEnd(14)
        val valorTotal = String.format("%.2f", total).padEnd(20)

        println("╔═════════════════════════════════════════════════════╗")
        println("║                      Meus Ganhos                    ║")
        println("╠═════════════════════════════════════════════════════╣")
        println("║  Valor Ganho  | Valor Perdido |        Total        ║")
        println("╠═══════════════╪═══════════════╪═════════════════════╣")
        println("║ $valorGanho| $valorPerdido| $valorTotal║")
        println("╚═══════════════╧═══════════════╧═════════════════════╝")
    }

}