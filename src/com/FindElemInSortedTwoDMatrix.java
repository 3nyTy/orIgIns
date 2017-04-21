package com.AH;

public class FindElemInSortedTwoDMatrix {
public static void main(String[] args) {

    int[][] mat = new int[][] { {10, 20, 30, 40}, 
                                {15, 25, 35, 45},
                                {27, 29, 37, 48},
                                {32, 33, 39, 50}};
    int rowCount=4;int colCount = 4;int key = 39;
    searchRec(mat,0,rowCount-1,0,colCount-1,key);
    searchNorm(mat,0,rowCount-1,0,colCount-1,key);
}

private static void searchNorm(int[][] mat, int fromRow, int toRow, int fromCol, int toCol, int key) {
	while(fromRow<=toRow && fromCol <= toCol){
	int rowMid = (fromRow+toRow)/2;
	int colMid = (fromCol+toCol)/2;
	
	if(mat[rowMid][colMid] == key) {
		System.out.println("Element "+key+" found at : "+rowMid +" , "+colMid);
	}else{
		if(rowMid != toRow || colMid!= fromCol ){
			toRow = rowMid;
			fromCol=colMid;
			continue;
		}
		
		if(mat[rowMid][colMid]<key){
			if(rowMid+1 <= toRow) fromRow = rowMid+1;
		}else{
			if(colMid-1>= fromCol) toCol = colMid-1;
		}
	}
	}
}

private static void searchRec(int[][] mat, int fromRow, int toRow, int fromCol, int toCol, int key) {
	int i=(fromRow+toRow)/2;
	int j =(fromCol+toCol)/2;
	if(mat[i][j] == key ) 
		System.out.println("Element "+key+" found at : "+i +" , "+j);
	else{
		// right-up quarter of matrix is searched in all cases.
        // Provided it is different from current call
		if(i!=toRow || j!=fromCol){
			searchRec(mat,fromRow,i,j,toCol,key);
		}
		
		  // Special case for iteration with 1*2 matrix
        // mat[i][j] and mat[i][j+1] are only two elements.
        // So just check second element
		if(fromRow==toRow && fromCol+1 ==toCol){
			if(mat[fromRow][toCol]==key)
				System.out.println("Element "+key+" found at : "+fromRow +" , "+toCol);
		}
		 // If middle key is lesser then search lower horizontal 
        // matrix and right hand side matrix
		if(mat[i][j] < key ){
			 // search lower horizontal if such matrix exists
			if(i+1<= toRow)
				searchRec(mat,i+1,toRow,fromCol,toCol,key);
			// If middle key is greater then search left vertical 
            // matrix and right hand side matrix
		}else{
			// search left vertical if such matrix exists
			if(j-1 >=fromCol)
				searchRec(mat,fromRow,toRow,fromCol,j-1,key);
		}
		
		
	}
	
}
}
