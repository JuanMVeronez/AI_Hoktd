package entity;

public class Table {
        
        private int N;
        private char[][] tableMap;
        
        public Table(int N, char[][] tableMap) {
            this.N = N;
            this.tableMap = tableMap;
        }

        public Table startGame() {
            if(this.getPlayerPosition() != null) {
                throw new IllegalArgumentException("Game already started!");
            }
            
            tableMap[0][0] = '*';
            return this;
        }
        
        public int getN() {
            return N;
        }
        
        public char[][] getTableMap() {
            return tableMap;
        }

        public boolean isObjective() {
            return tableMap[N-1][N-1] == '*';
        }

        public int getDistance() {
            Position pos = this.getPlayerPosition();
            return (N-1) - pos.line + (N-1) - pos.row;
        }
        
        public Table getObjectiveTable() {
            char[][] tableMapClone = this.copyTableMap();
            tableMapClone[N-1][N-1] = '*';

            return new Table(N, tableMapClone);
        }

        public Table deepCopy() {
            char[][] tableMapClone = this.copyTableMap();
            return new Table(N, tableMapClone);
        }

        public char[][] copyTableMap() {
            char[][] tableMapClone = new char[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    tableMapClone[i][j] = tableMap[i][j];
                }
            }

            return tableMapClone;
        }

        public boolean isValidAction(Action action) {
            Position pos = this.getPlayerPosition();

            int newI = pos.line;
            int newJ = pos.row;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Action[] actions = {Action.N, Action.S, Action.L, Action.O};

            for (int k = 0; k < directions.length; k++) {
                if (action == actions[k]) {
                    newI += directions[k][0];
                    newJ += directions[k][1];
                    break;
                }
            }

            boolean isInBounds = newI >= 0 && newI < N && newJ >= 0 && newJ < N;

            return isInBounds && tableMap[newI][newJ] != 'T' && tableMap[newI][newJ] != '1';
        }

        public void act(Action action) {
            Position pos = this.getPlayerPosition();
            int i = pos.line;
            int j = pos.row;

            switch(action) {
                case N:
                    tableMap[i][j] = '1';
                    tableMap[i-1][j] = '*';
                    break;
                case S:
                    tableMap[i][j] = '1';
                    tableMap[i+1][j] = '*';
                    break;
                case L:
                    tableMap[i][j] = '1';
                    tableMap[i][j-1] = '*';
                    break;
                case O:
                    tableMap[i][j] = '1';
                    tableMap[i][j+1] = '*';
                    break;
            }
        }
        public int getPositionHits() {
            Position pos = this.getPlayerPosition();
            int hits = 0;

            for (int i = pos.line-1; i <= pos.line+1; i++) {
                for (int j = pos.row-1 ; j <= pos.row+1; j++) {
                    if (i >= 0 && i < N && j >= 0 && j <N && tableMap[i][j] == 'T') hits++;
                }
            }

            return hits * 10;
        }

        public Position getPlayerPosition() {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(this.tableMap[i][j] == '*') {
                        return new Position(i, j);
                    }
                }
            }
            return null;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Table) {
                Table t = (Table) obj;
                if(t.getN() != this.getN()) {
                    return false;
                }
                char[][] tMap = t.getTableMap();
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(tMap[i][j] != tableMap[i][j]) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(tableMap[i][j]);
                }
                sb.append("\n");
            }
            return sb.toString();
        }
}
