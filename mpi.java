#include <mpi.h>
#include <stdio.h>

int main(int argc, char** argv) {
        int rank;
        int buf;
        const int root=0;
        int data;
	int ack = 1;
        MPI_Init(&argc, &argv);
        MPI_Comm_rank(MPI_COMM_WORLD, &rank);

        if(rank == root) {
           buf = 777;
        }

        printf("[%d]: Before Bcast, buf is %d\n", rank, buf);

        /* everyone calls bcast, data is taken from root and ends up in everyone's buf */
        MPI_Bcast(&buf, 1, MPI_INT, root, MPI_COMM_WORLD);
        printf("[%d]: After Bcast, buf is %d\n", rank, buf);
	if(rank == 1)
	{
		MPI_Send(&ack, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);
	}
	if(rank == root)
	{
		MPI_Recv(&data, 1, MPI_INT, 1, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		printf("Recieved data %d from process\n", data);
        }
        MPI_Finalize();
        return 0;
}

To run
mpicc -o a mpi.c
mpirun -np 6 ./a
