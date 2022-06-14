// input of vending machine inventory -> purchase attempts
/*
   inventory[]: [{col}, {row}, {price in cents}, {quantity}]
   purchaseAttempts[]: [{col}, {row}]

   calc value of all remaining items AFTER deducting successful purchase attemps
*/

function vendingItem(arr) {
    return {
        column: arr[0],
        row: arr[1],
        costCents: arr[2],
        remainingQuantity: arr[3]
    };
}

const solution = (inventory, purchaseAttempts) => {
    const items = inventory.map(vendingItem).filter(x => x);
    console.log(items);
    const columnCount = items.reduce((acc, item) => { return Math.max(acc, item.row) }, 0) + 1;
    const rowCount = items.reduce((acc, item) => { return Math.max(acc, item.column) }, 0) + 1;

    var grid = Array(columnCount).fill(Array(rowCount).fill(null));
    for (item of items) {
        grid[item.column][item.row] = item;
    }

    for (purchaseCoordinate of purchaseAttempts) {
        if (purchaseCoordinate.length != 2 || isNaN(purchaseCoordinate[0]) || isNaN(purchaseCoordinate[1])) {
            continue;
        }

        const purchaseColumn = purchaseCoordinate[0];
        const purchaseRow = purchaseCoordinate[1];
        if (grid.count <= purchaseColumn) {
            continue;
        }

        const column = grid[purchaseColumn];
        if (column == null || column.length <= purchaseRow) {
            continue;
        }

        var item = column[purchaseRow];
        item.remainingQuantity--;
    }

    return items.reduce((acc, item) => { return acc + (item.remainingQuantity * item.costCents) }, 0);
}

console.log(solution([[0, 1, 100, 2], [0, 2, 50, 1]], [[0, 1], [0, 1], [0, 0]]));
