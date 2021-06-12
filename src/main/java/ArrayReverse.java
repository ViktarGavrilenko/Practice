// TODO agorozhanko 12.06.2021: какая должна быть первоначальная структура проекта?

// TODO agorozhanko 12.06.2021: нужно логически вынести в классы и пакеты утилитные методы, бизнес логику, так чтобы
//  формировались слои проекта

// TODO agorozhanko 12.06.2021: все задачи нужно вынести в методы
// TODO agorozhanko 12.06.2021: методы должны быть универсальными

// TODO agorozhanko 12.06.2021: все задачи нужно выполнять в одном классе (одном мэйн методе)

// TODO agorozhanko 12.06.2021: программа должна быть отказоустойчивой, нужно предусматривать в коде критические
//  ситуации, которые могут привести к поломкам программы


public class ArrayReverse {
// TODO agorozhanko 12.06.2021: что будет если ввести пустой или неинициализированный массив?

    public int[] reverseArray(int[] inArray) {

        int tempVariable;
        int lastValue = inArray.length - 1;

        for (int x = 0; x < inArray.length / 2; x++) {
            tempVariable = inArray[x];
            inArray[x] = inArray[lastValue];
            inArray[lastValue] = tempVariable;
            lastValue--;
        }

        return inArray;
    }
}
