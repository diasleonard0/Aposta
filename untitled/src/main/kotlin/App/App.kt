package App

import Resources.ResourcesApp

class App {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val resource = ResourcesApp()
            resource.logo()

            // Etapa 1: Times
            val timesPeople = TimesPeople()
            resource.iRegisterTime()
            val listTimesPeople = timesPeople.main()

            // Etapa 2: Jogadores e Apostas
            val players = Players()
            resource.iBetRegistration()
            val listPlayers = players.main(listTimesPeople)

            // Etapa 3: Vencedor
            resource.iWinners()
            val winner = timesPeople.winner(listTimesPeople)

            // Etapa 4: Tabelas dos Ganhadores, Perdedores e Meu Lucro
            val summary = Summary()
            resource.iSummary()
            summary.main(listPlayers, winner)

        }
    }
}