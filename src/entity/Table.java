package entity;

public class Table {
        
        private int N;
        private char[][] tableMap;
        
        public Table(int N, char[][] tableMap) {
            this.N = N;
            tableMap[0][0] = '1';
            this.tableMap = tableMap;
        }
        
        public int getN() {
            return N;
        }
        
        public char[][] getTableMap() {
            return tableMap;
        }

        public boolean isObjective() {
            return tableMap[N-1][N-1] == '1';
        }
        
        public Table getObjectiveTable() {
            char[][] tableMapClone = this.copyTableMap();
            tableMapClone[N-1][N-1] = '1';

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
            int i = pos.line;
            int j = pos.row;

            switch(action) {
                case N:
                    return i > 0 && tableMap[i-1][j] != 'T';
                case S:
                    return i < N-1 && tableMap[i+1][j] != 'T';
                case L:
                    return j > 0 && tableMap[i][j-1] != 'T';
                case O:
                    return j < N-1 && tableMap[i][j+1] != 'T';
                default:
                    return false;
            }
        }

        public void act(Action action) {
            Position pos = this.getPlayerPosition();
            int i = pos.line;
            int j = pos.row;

            switch(action) {
                case N:
                    tableMap[i][j] = '0';
                    tableMap[i-1][j] = '1';
                    break;
                case S:
                    tableMap[i][j] = '0';
                    tableMap[i+1][j] = '1';
                    break;
                case L:
                    tableMap[i][j] = '0';
                    tableMap[i][j-1] = '1';
                    break;
                case O:
                    tableMap[i][j] = '0';
                    tableMap[i][j+1] = '1';
                    break;
            }
        }

        public Position getPlayerPosition() {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(tableMap[i][j] == '1') {
                        
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
