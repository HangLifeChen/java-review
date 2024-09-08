# 数字华容道StonMaze
### 一、项目开发步骤
#### 1、创建界面（基于GUI界面）：

#### 2、打乱顺序
```java
private void initRandom(){//打乱二维数组的顺序
//        for(int i=0;i<img.length;i++){
//            for(int j=0;j<img[i].length;j++){
//                int temp=img[i][j];
//                int row=(int)(Math.random()*4);
//                int col=(int)(Math.random()*4);
//                img[i][j]=img[row][col];
//                img[row][col]=temp;
//            }
//        }//简单粗暴的打乱数组
        //数字华容道有规律的打乱
        for(int i=0;i<img.length;i++)
        for(int j=0;j<img[i].length;j++)
        img[i][j]=win[i][j];
        Random random=new Random();
        int blankRow=img.length-1; // 空白格初始在最后一行
        int blankCol=img.length-1; // 空白格初始在最后一列
        int inversions=countInversions();

    while(true){
        // 随机选择一个方向
        int direction=random.nextInt(3);
        int[]Direction={0,1,0,-1};
        int newRow=blankRow+Direction[direction];
        int newCol=blankCol+Direction[direction+1];
        if(newRow>=0&&newRow<img.length&&newCol>=0&&newCol<img.length){
            swap(blankRow,blankCol,newRow,newCol);
            int newInversions=countInversions();
            boolean isSolvable=(blankRow==img.length-1)?(newInversions%2==0):(newInversions%2!=0);
    
            if(isSolvable){
                    blankRow=newRow;
                    blankCol=newCol;
                    inversions=newInversions;
            }else{
                swap(newRow,newCol,blankRow,blankCol);
            }
        }
        if(random.nextInt(1000)==0)break;
    }
    //找到空白色块位置
    OUT:
    for(int i=0;i<img.length;i++){
        for(int j=0;j<img[i].length;j++){
            if(img[i][j]==0){
                row=i;
                col=j;
                break OUT;//退出整个循环
            }
        }
    }
}
private void swap(int row1, int col1, int row2, int col2) {
    int temp = img[row1][col1];
    img[row1][col1] = img[row2][col2];
    img[row2][col2] = temp;
}
private int countInversions() {
    // 实现计算逆序数的逻辑
    int inversions = 0;
    for (int i = 0; i < img.length; i++) {
        for (int j = 0; j < img.length; j++) {
            if (img[i][j] == 0) continue;
            for (int k = i * img.length + j + 1; k < img.length *img.length; k++) {
                int row = k / img.length;
                int col = k % img.length;
                if (img[i][j] > img[row][col]) {
                    inversions++;
                }
            }
        }
    }
    return inversions;
}
```
#### 3、控制上下左右移动

#### 4、判断是否胜利

#### 5、统计移动步骤、重启游戏

#### 6、添加作弊获胜选项

### 二、学习链接
[黑马程序员Java](https://www.bilibili.com/video/BV1gb42177hm?p=106&vd_source=2140b8696bb75ad7bd33e1195bf24372)
